import React from "react";
import {
  Checkbox,
  FormControlLabel,
  FormGroup,
  Box,
  Divider,
} from "@mui/material";
import OrderCard from "./OrderCard";

const Order = () => {
  const [filters, setFilters] = React.useState({
    onTheWay: false,
    delivered: false,
    cancelled: false,
    returned: false,
  });

  const handleFilterChange = (event: React.ChangeEvent<HTMLInputElement>) => {
    const { name, checked } = event.target;
    setFilters((prev) => ({ ...prev, [name]: checked }));
  };

  return (
    <div className="p-4 flex flex-row mx-20 gap-8">
      {/* Filters Section */}
      <Box
        sx={{
          width: "30%",
          backgroundColor: "#fff",
          borderRadius: "8px",
          boxShadow: "0px 2px 8px rgba(0, 0, 0, 0.1)",
          padding: "16px",
        }}
      >
        <h3 className="text-lg font-semibold mb-4 text-gray-800">Filters</h3>
        <Divider sx={{ mb: 2 }} />
        <h4 className="text-sm font-medium text-gray-600 mb-2">ORDER STATUS</h4>
        <FormGroup>
          <FormControlLabel
            control={
              <Checkbox
                checked={filters.onTheWay}
                onChange={handleFilterChange}
                name="onTheWay"
                sx={{
                  "&.Mui-checked": {
                    color: "#007BFF",
                  },
                }}
              />
            }
            label={<span className="text-sm text-gray-700">On the Way</span>}
          />
          <FormControlLabel
            control={
              <Checkbox
                checked={filters.delivered}
                onChange={handleFilterChange}
                name="delivered"
                sx={{
                  "&.Mui-checked": {
                    color: "#007BFF",
                  },
                }}
              />
            }
            label={<span className="text-sm text-gray-700">Delivered</span>}
          />
          <FormControlLabel
            control={
              <Checkbox
                checked={filters.cancelled}
                onChange={handleFilterChange}
                name="cancelled"
                sx={{
                  "&.Mui-checked": {
                    color: "#007BFF",
                  },
                }}
              />
            }
            label={<span className="text-sm text-gray-700">Cancelled</span>}
          />
          <FormControlLabel
            control={
              <Checkbox
                checked={filters.returned}
                onChange={handleFilterChange}
                name="returned"
                sx={{
                  "&.Mui-checked": {
                    color: "#007BFF",
                  },
                }}
              />
            }
            label={<span className="text-sm text-gray-700">Returned</span>}
          />
        </FormGroup>
      </Box>

      {/* Orders Section */}
      <div className="flex-1">
        <h3 className="text-lg font-semibold mb-4 text-gray-800">Order List</h3>
        <div className="bg-white p-4 rounded-lg shadow-md gap-4 flex flex-col">
          {[1, 2, 3].map((item, index) => (
            <OrderCard key={index} />
          ))}
        </div>
      </div>
    </div>
  );
};

export default Order;
