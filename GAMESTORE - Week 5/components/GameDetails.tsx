import React, { useEffect, useState } from "react";
import { Box, Heading, Text, Image, Button, useToast, Stack } from "@chakra-ui/react";
import { useParams, useNavigate } from "react-router-dom";

const GameDetails: React.FC = () => {
  const { id } = useParams<{ id: string }>();
  const [game, setGame] = useState<any>(null);
  const toast = useToast();
  const navigate = useNavigate();

  useEffect(() => {
    const fetchGameDetails = async () => {
      try {
        const response = await fetch(
          `https://api.rawg.io/api/games/${id}?key=b87b1e0489674169802e79a5b37a5993`
        );
        const data = await response.json();
        setGame(data);
      } catch (error) {
        toast({
          title: "Error",
          description: "Failed to fetch game details.",
          status: "error",
          duration: 3000,
          isClosable: true,
        });
      }
    };

    fetchGameDetails();
  }, [id]);

  if (!game) {
    return <Box>Loading...</Box>;
  }

  return (
    <Box p={4}>
      {/* Back Button */}
      <Button onClick={() => navigate("/")} mb={4} colorScheme="accent">
        Back to Home
      </Button>

      {/* Game Details */}
      <Stack spacing={4}>
        <Heading>{game.name}</Heading>

        {/* Game Image */}
        <Image
          src={game.background_image}
          alt={game.name}
          borderRadius="lg"
          width="600px" // Fixed width
          height="400px" // Fixed height
          objectFit="cover"
          mx="auto" // Center the image
        />

        {/* Game Description */}
        <Text>{game.description_raw}</Text>

        {/* Additional Details */}
        <Text>Released: {game.released}</Text>
        <Text>Rating: {game.metacritic || "N/A"}</Text>

        {/* Buy Now Button */}
        <Button mt={4} colorScheme="accent">
          Buy Now
        </Button>
      </Stack>
    </Box>
  );
};

export default GameDetails;