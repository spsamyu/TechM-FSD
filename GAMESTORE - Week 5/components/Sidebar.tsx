import React from "react";
import { VStack, Button, Box, Text } from "@chakra-ui/react";

interface SidebarProps {
  onGenreClick: (genreId: string) => void;
}

const Sidebar: React.FC<SidebarProps> = ({ onGenreClick }) => {
  const genres = [
    { id: "4", name: "Action" },
    { id: "3", name: "Adventure" },
    { id: "5", name: "RPG" },
    { id: "2", name: "Shooter" },
    { id: "10", name: "Strategy" },
  ];

  return (
    <Box p={4}>
      <Text fontSize="xl" fontWeight="bold" mb={4}>
        Genres
      </Text>
      <VStack align="start">
        {genres.map((genre) => (
          <Button
            key={genre.id}
            variant="ghost"
            colorScheme="accent"
            onClick={() => onGenreClick(genre.id)}
            w="100%"
            justifyContent="flex-start"
          >
            {genre.name}
          </Button>
        ))}
      </VStack>
    </Box>
  );
};

export default Sidebar;