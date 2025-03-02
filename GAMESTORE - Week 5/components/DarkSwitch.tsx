import { HStack, Switch, useColorMode } from "@chakra-ui/react";
function DarkSwitch() {
  let { colorMode, toggleColorMode } = useColorMode();
  return (
    <HStack>
      <Switch
        colorScheme="green"
        isChecked={colorMode == "dark"}
        onChange={toggleColorMode}
      >
        Dark Mode
      </Switch>
    </HStack>
  );
}
export default DarkSwitch;
