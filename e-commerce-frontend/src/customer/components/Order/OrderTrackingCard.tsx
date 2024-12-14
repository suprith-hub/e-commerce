import { StarIcon } from "@heroicons/react/24/outline";
import { Typography, Button } from "@mui/material";
import React from "react";

const OrderTrackingCard = () => {
  return (
    <div className="flex flex-row items-center justify-between bg-white shadow-md p-4 rounded-lg border border-gray-200">
      {/* Product Image */}
      <img
        src="https://via.placeholder.com/100"
        alt="Product"
        className="w-24 h-24 rounded-md object-cover"
      />

      {/* Product Details */}
      <div className="flex flex-col flex-grow ml-4">
        <Typography
          variant="h6"
          sx={{
            fontSize: "18px",
            fontWeight: 600,
            color: "#111927",
          }}
        >
          Men’s Jeans
        </Typography>
        <div className="flex flex-row">
          <Typography
            sx={{ fontSize: "14px", fontWeight: 500, color: "#6B7280" }}
          >
            Size: M |
          </Typography>
          <Typography
            sx={{ fontSize: "14px", fontWeight: 500, color: "#6B7280" }}
          >
            Color: Black
          </Typography>
        </div>
        <Typography
          sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
        >
          Seller: {"SD"}
        </Typography>
        <Typography
          sx={{
            fontSize: "16px",
            fontWeight: 600,
            color: "#111927",
            marginTop: "8px",
          }}
        >
          $199
        </Typography>
      </div>

      <div onClick={() => null} className="flex flex-row items-center gap-2">
        <StarIcon className="h-6 w-6 text-gray-400" />

        <Typography
          sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
        >
          Rate and Review Product
        </Typography>
      </div>
    </div>
  );
};

export default OrderTrackingCard;
