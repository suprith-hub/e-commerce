import { Typography, Button } from "@mui/material";
import React from "react";
import { useNavigate } from "react-router-dom";

const OrderCard = () => {
  const navigate = useNavigate();
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
        <Typography
          sx={{ fontSize: "14px", fontWeight: 500, color: "#6B7280" }}
        >
          Size: M
        </Typography>
        <Typography
          sx={{ fontSize: "14px", fontWeight: 500, color: "#6B7280" }}
        >
          Color: Black
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

      {/* Delivery Information */}
      <div className="flex flex-col items-end">
        {true ? (
          <Typography
            sx={{
              fontSize: "14px",
              fontWeight: 500,
              color: "#111927",
              marginBottom: "4px",
            }}
          >
            Expected delivery by:{" "}
            <span className="text-green-600">Tomorrow</span>
          </Typography>
        ) : (
          <Typography
            sx={{
              fontSize: "14px",
              fontWeight: 500,
              color: "#111927",
              marginBottom: "4px",
            }}
          >
            Delivered on: <span className="text-green-600">Tomorrow</span>
          </Typography>
        )}
        {true ? (
          <Typography sx={{ fontSize: "14px", fontWeight: 600, color: "gray" }}>
            Item on the way
          </Typography>
        ) : (
          <Typography
            sx={{ fontSize: "14px", fontWeight: 600, color: "#16A34A" }}
          >
            Your items has been delivered
          </Typography>
        )}
        <Button
          variant="outlined"
          size="small"
          sx={{
            marginTop: "12px",
            textTransform: "capitalize",
            borderColor: "#6B7280",
            color: "#6B7280",
          }}
          onClick={() => navigate("/account/order/2")}
        >
          View Details
        </Button>
      </div>
    </div>
  );
};

export default OrderCard;
