import React from "react";
import { Box, Text, Link, Flex, Icon } from "@chakra-ui/react";
import { FaTwitter, FaFacebook, FaInstagram } from "react-icons/fa"; // Import icons

const Footer: React.FC = () => {
  return (
    <Box textAlign="center" p={5} bg="brand.900" color="white">
      <Flex justifyContent="center" gap={4} mb={2}>
        <Link href="#" color="accent.500">
          About Us
        </Link>
        <Link href="#" color="accent.500">
          Contact
        </Link>
        <Link href="#" color="accent.500">
          Privacy Policy
        </Link>
      </Flex>
      <Flex justifyContent="center" gap={4} mb={2}>
        <Link href="#" color="accent.500">
          <Icon as={FaTwitter} boxSize={6} />
        </Link>
        <Link href="#" color="accent.500">
          <Icon as={FaFacebook} boxSize={6} />
        </Link>
        <Link href="#" color="accent.500">
          <Icon as={FaInstagram} boxSize={6} />
        </Link>
      </Flex>
      <Text>&copy; 2023 GameHub. All rights reserved.</Text>
    </Box>
  );
};

export default Footer;