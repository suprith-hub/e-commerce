import { useEffect, useState } from "react";
import { Box } from "@mui/material";
import { Routes, Route } from "react-router-dom";
import CustomerRouter from "./customer/routers/CustomerRouter";

function App() {
  const [count, setCount] = useState(0);
  useEffect(() => {}, []);

  return (
    <Box>
      {/* The root route here should be '/' */}
      <Routes>
        <Route path="/*" element={<CustomerRouter />}></Route>
      </Routes>
    </Box>
  );
}

export default App;
