import React, { useState, useEffect } from "react";
import { Grid, GridItem, Box, Flex, Button, useToast, Text } from "@chakra-ui/react";
import NavBar from "./components/NavBar";
import GameCard from "./components/GameCard";
import Sidebar from "./components/Sidebar";
import Footer from "./components/Footer";
import { BrowserRouter as Router, Route, Routes, useNavigate } from "react-router-dom";
import GameDetails from "./components/GameDetails";

function App() {
  const [games, setGames] = useState([]);
  const [page, setPage] = useState(1);
  const [totalPages, setTotalPages] = useState(1);
  const [searchQuery, setSearchQuery] = useState("");
  const [genre, setGenre] = useState("");
  const toast = useToast();

  const fetchGames = async (page: number, query: string = "", genre: string = "") => {
    try {
      let url = `https://api.rawg.io/api/games?key=b87b1e0489674169802e79a5b37a5993&page=${page}&search=${query}`;
      if (genre) {
        url += `&genres=${genre}`;
      }
      const response = await fetch(url);
      const data = await response.json();
      setGames(data.results);
      setTotalPages(Math.ceil(data.count / 20)); // Assuming 20 items per page
    } catch (error) {
      toast({
        title: "Error",
        description: "Failed to fetch games.",
        status: "error",
        duration: 3000,
        isClosable: true,
      });
    }
  };

  useEffect(() => {
    fetchGames(page, searchQuery, genre);
  }, [page, searchQuery, genre]);

  const handleSearch = (query: string) => {
    setSearchQuery(query);
    setPage(1);
  };

  const handleGenreClick = (genreId: string) => {
    setGenre(genreId);
    setPage(1);
  };

  const handlePageChange = (newPage: number) => {
    setPage(newPage);
  };

  // Generate page numbers (only 5 pages at a time)
  const getPageNumbers = () => {
    const pages = [];
    const startPage = Math.max(1, page - 2);
    const endPage = Math.min(totalPages, startPage + 4);

    for (let i = startPage; i <= endPage; i++) {
      pages.push(i);
    }
    return pages;
  };

  return (
    <Router>
      <Grid
        templateAreas={{
          base: `"nav" "main" "footer"`,
          lg: `"nav nav" "side main" "footer footer"`,
        }}
        templateRows={{ base: "auto 1fr auto", lg: "auto 1fr auto" }}
        templateColumns={{ base: "1fr", lg: "250px 1fr" }}
        minH="100vh"
        gap={4}
        bg="background.dark"
      >
        {/* NavBar */}
        <GridItem area={"nav"}>
          <NavBar onSearch={handleSearch} />
        </GridItem>

        {/* Sidebar */}
        <GridItem area={"side"} bg={"brand.800"} display={{ base: "none", lg: "block" }}>
          <Sidebar onGenreClick={handleGenreClick} />
        </GridItem>

        {/* Main Content */}
        <GridItem area={"main"} p={4}>
          <Box maxW="1200px" mx="auto">
            {/* Game Cards */}
            <Routes>
              <Route path="/" element={<GameCard games={games} />} />
              <Route path="/game/:id" element={<GameDetails />} />
            </Routes>

            {/* Pagination */}
            <Flex justifyContent="center" mt={6} alignItems="center">
              <Button
                onClick={() => handlePageChange(page - 1)}
                isDisabled={page === 1}
                mr={2}
                colorScheme="accent"
              >
                Previous
              </Button>
              {getPageNumbers().map((pageNumber) => (
                <Button
                  key={pageNumber}
                  onClick={() => handlePageChange(pageNumber)}
                  variant={pageNumber === page ? "solid" : "outline"}
                  colorScheme="accent"
                  mx={1}
                >
                  {pageNumber}
                </Button>
              ))}
              <Button
                onClick={() => handlePageChange(page + 1)}
                isDisabled={page === totalPages}
                ml={2}
                colorScheme="accent"
              >
                Next
              </Button>
            </Flex>
          </Box>
        </GridItem>

        {/* Footer */}
        <GridItem area={"footer"} bg={"brand.900"}>
          <Footer />
        </GridItem>
      </Grid>
    </Router>
  );
}

export default App;