import React from "react";
import AddressCard from "../AddressCard/AddressCard";
import CartItem from "../Cart/CartItem";
import { Button } from "@mui/material";

const OrderSummary = () => {
  return (
    <div className="p-4">
      {/* Address Section */}
      <div className="mb-6">
        <AddressCard />
      </div>

      {/* Order and Price Details */}
      <div className="flex flex-col lg:flex-row gap-6">
        {/* Cart Items Section */}
        <div className="flex-1">
          {[1, 2, 3].map((item, index) => (
            <CartItem key={index} item={item} />
          ))}
        </div>

        {/* Price Details Section */}
        <div className="w-full lg:w-1/3 bg-gray-50 border border-gray-200 rounded-lg p-4 shadow">
          <p className="text-lg font-semibold mb-4">PRICE DETAILS</p>
          <div className="flex justify-between text-sm mb-3">
            <p>Discount</p>
            <p>$199</p>
          </div>
          <div className="flex justify-between text-sm mb-3">
            <p>Subtotal</p>
            <p>$399</p>
          </div>
          <div className="flex justify-between text-sm mb-3">
            <p>Delivery Charge</p>
            <p className="text-green-700">Free</p>
          </div>
          <div className="flex justify-between text-base font-medium border-t pt-3 mt-3">
            <p>Total Amount</p>
            <p>$599</p>
          </div>
          <Button
            variant="contained"
            color="primary"
            sx={{ width: "100%", marginTop: "1rem" }}
          >
            Checkout
          </Button>
        </div>
      </div>
    </div>
  );
};

export default OrderSummary;
