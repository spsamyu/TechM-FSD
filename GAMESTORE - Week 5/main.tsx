import React from "react";
import { ChakraProvider, ColorModeScript } from "@chakra-ui/react";
import ReactDOM from "react-dom/client";
import App from "./App";
import theme from "./theme";
// import "./index.css";

ReactDOM.createRoot(document.getElementById("root") as HTMLElement).render(
  <React.StrictMode>
    <ChakraProvider theme={theme}>
      <ColorModeScript initialColorMode={theme.config.initialColorMode} />
      <App />
    </ChakraProvider>
  </React.StrictMode>
);
//b87b1e0489674169802e79a5b37a5993 - api key
// side bar (drawer)
// cards UI
// Footer
// PAGINATION