import { extendTheme, type ThemeConfig } from "@chakra-ui/react";

const config: ThemeConfig = {
  initialColorMode: "dark",
  useSystemColorMode: false,
};

const theme = extendTheme({
  config,
  colors: {
    brand: {
      900: "#0A0F1F",
      800: "#1A2138",
      700: "#2A3651",
      500: "#3C4C6D",
      300: "#5C6C8A",
    },
    accent: {
      500: "#FF6B6B",
      600: "#FF5252",
    },
    background: {
      dark: "#0A0F1F",
      light: "#F7FAFC",
    },
  },
  styles: {
    global: {
      body: {
        bg: "background.dark",
        color: "white",
      },
    },
  },
});

export default theme;