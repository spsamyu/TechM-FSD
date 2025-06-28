import React from "react";
import { Flex, Image, Input, Button, Text, Box } from "@chakra-ui/react";
import logo from "../assets/logo.png"; // Add your logo here
import DarkSwitch from "./DarkSwitch";

interface NavBarProps {
  onSearch: (query: string) => void;
}

const NavBar: React.FC<NavBarProps> = ({ onSearch }) => {
  const [query, setQuery] = React.useState("");

  const handleSearch = (e: React.FormEvent) => {
    e.preventDefault();
    onSearch(query);
  };

  return (
    <Flex
      justifyContent="space-between"
      alignItems="center"
      p={4}
      bg="brand.900"
      boxShadow="md"
    >
      {/* Logo and Store Name */}
      <Flex alignItems="center">
        <Image src={logo} boxSize={50} borderRadius="full" mr={3} />
        <Text fontSize="2xl" fontWeight="bold" color="accent.500">
        LevelUp
        </Text>
      </Flex>

      {/* Search Bar */}
      <Box flex={1} mx={8}>
        <form onSubmit={handleSearch}>
          <Flex>
            <Input
              placeholder="Search games..."
              value={query}
              onChange={(e) => setQuery(e.target.value)}
              bg="white"
              color="black"
              flex={1}
              mr={2}
            />
            <Button type="submit" colorScheme="accent">
              Search
            </Button>
          </Flex>
        </form>
      </Box>

      {/* Dark Mode Switch */}
      <DarkSwitch />
    </Flex>
  );
};

export default NavBar;