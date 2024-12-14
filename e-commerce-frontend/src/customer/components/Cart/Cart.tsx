import { Box, Button, Divider, Typography } from "@mui/material";
import React from "react";
import CartItem from "./CartItem";
import { useNavigate } from "react-router-dom";

const Cart = () => {
  const navigate = useNavigate();
  return (
    <div className="flex flex-row px-4 mx-20 gap-4">
      {/* Left side: Cart Items */}
      <div className="w-2/3">
        <Typography variant="h4" component="h1" gutterBottom>
          Shopping Cart
        </Typography>
        <Divider sx={{ marginBottom: 2 }} />
        <div className="flex flex-col gap-2">
          {[1, 1, 1].map((item, index) => (
            <CartItem key={index} item={item} />
          ))}
        </div>
      </div>

      {/* Right side: Order Summary */}
      <div className="w-1/3 gap-y-2 mt-20">
        <Box
          sx={{
            padding: 2,
            backgroundColor: "#f4f4f4", // Light background for the order summary
            borderRadius: "8px", // Rounded corners
            boxShadow: 2, // Slight shadow to give it depth
          }}
        >
          <Typography variant="h6" component="h2" sx={{ marginBottom: 2 }}>
            Order Summary
          </Typography>

          {/* Subtotal Row */}
          <Box
            sx={{
              display: "flex",
              justifyContent: "space-between",
              marginBottom: 1,
            }}
          >
            <Typography
              sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
            >
              Subtotal
            </Typography>
            <Typography
              sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
            >
              $199
            </Typography>
          </Box>
          <Divider sx={{ marginBottom: 1 }} />

          {/* Tax Row */}
          <Box
            sx={{
              display: "flex",
              justifyContent: "space-between",
              marginBottom: 1,
            }}
          >
            <Typography
              sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
            >
              Tax
            </Typography>
            <Typography
              sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
            >
              $19
            </Typography>
          </Box>
          <Divider sx={{ marginBottom: 1 }} />

          {/* Shipping Row */}
          <Box
            sx={{
              display: "flex",
              justifyContent: "space-between",
              marginBottom: 1,
            }}
          >
            <Typography
              sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
            >
              Shipping
            </Typography>
            <Typography
              sx={{ fontSize: "14px", fontWeight: 500, color: "#111927" }}
            >
              $10
            </Typography>
          </Box>
          <Divider sx={{ marginBottom: 1 }} />

          {/* Total Row */}
          <Box
            sx={{
              display: "flex",
              justifyContent: "space-between",
              marginBottom: 2,
            }}
          >
            <Typography
              sx={{ fontSize: "16px", fontWeight: 700, color: "#111927" }}
            >
              Order Total
            </Typography>
            <Typography
              sx={{ fontSize: "16px", fontWeight: 700, color: "#111927" }}
            >
              $228
            </Typography>
          </Box>

          <Divider sx={{ marginBottom: 1 }} />

          <Button
            onClick={() => navigate("/checkout?step=2")}
            sx={{ width: "100%", backgroundColor: "purple", color: "white" }}
          >
            Checkout
          </Button>
        </Box>
      </div>
    </div>
  );
};

export default Cart;
