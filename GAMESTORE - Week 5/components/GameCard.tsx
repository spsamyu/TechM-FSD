import React from "react";
import {
  Card,
  CardBody,
  Image,
  Text,
  Heading,
  Stack,
  Divider,
  CardFooter,
  ButtonGroup,
  Button,
  Box,
} from "@chakra-ui/react";
import { useNavigate } from "react-router-dom";

interface Game {
  id: number;
  name: string;
  background_image: string;
  released: string;
  metacritic: number;
}

interface GameCardProps {
  games: Game[];
}

const GameCard: React.FC<GameCardProps> = ({ games }) => {
  const navigate = useNavigate();

  return (
    <Box display="grid" gridTemplateColumns="repeat(auto-fill, minmax(300px, 1fr))" gap={6}>
      {games.map((game) => (
        <Card
          key={game.id}
          bg="brand.700"
          borderRadius="lg"
          overflow="hidden"
          boxShadow="lg"
          _hover={{ transform: "scale(1.05)", transition: "transform 0.2s" }}
        >
          <CardBody>
            <Image
              src={game.background_image}
              alt={game.name}
              borderRadius="lg"
              h="200px"
              w="100%"
              objectFit="cover"
            />
            <Stack mt="6" spacing="3">
              <Heading size="md">{game.name}</Heading>
              <Text>Released: {game.released}</Text>
              <Text color="accent.500" fontSize="2xl">
                Rating: {game.metacritic || "N/A"}
              </Text>
            </Stack>
          </CardBody>
          <Divider />
          <CardFooter>
            <ButtonGroup spacing="2">
              <Button
                variant="solid"
                colorScheme="accent"
                onClick={() => navigate(`/game/${game.id}`)}
              >
                Buy Now
              </Button>
              <Button variant="ghost" colorScheme="accent">
                Add to cart
              </Button>
            </ButtonGroup>
          </CardFooter>
        </Card>
      ))}
    </Box>
  );
};

export default GameCard;