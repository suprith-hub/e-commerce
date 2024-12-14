import { MinusCircleIcon, PlusCircleIcon } from "@heroicons/react/24/outline";
import { Box, Button, IconButton } from "@mui/material";
import React, { useState } from "react";

const CartItem = ({ item }: { item: any }) => {
  const [quantity, setQuantity] = useState(1);

  return (
    <div className="w-full border border-gray-400 shadow p-4">
      {/* Top Row: Image and Details */}
      <div className="flex flex-row w-full gap-4">
        <img src={item.imageUrl} alt="" className="h-[13rem] w-[10rem]" />
        <div className="flex flex-col justify-between flex-1">
          <Box>
            <p className="font-medium">{item.name}</p>
            <div className="flex flex-row gap-2 text-sm text-gray-600">
              <p>{item.color}</p> | <p>{item.size}</p>
            </div>
            <p className="text-sm text-gray-500">Seller: {item.company}</p>
            <div className="flex flex-row gap-2 items-center">
              <p className="text-3xl tracking-tight text-gray-900">
                {item.discountedPrice}
              </p>
              <p className="line-through text-gray-500">{item.price}</p>
              <p className="text-green-600"> {item.discountPersent} Off </p>
            </div>
          </Box>
        </div>
      </div>

      {/* Bottom Row: Quantity and Remove Button */}
      <div className="flex justify-between items-center mt-4">
        {/* Quantity Controls */}
        <div className="flex flex-row items-center gap-4">
          <IconButton
            sx={{ width: "2rem", height: "2rem", padding: 0 }}
            disabled={quantity === 0}
            onClick={() => setQuantity(quantity > 0 ? quantity - 1 : 0)}
          >
            <MinusCircleIcon className="h-6 w-6" />
          </IconButton>
          <p className="text-lg">{quantity}</p>
          <IconButton
            sx={{ width: "2rem", height: "2rem", padding: 0 }}
            onClick={() => setQuantity(quantity + 1)}
          >
            <PlusCircleIcon className="h-6 w-6" />
          </IconButton>
        </div>

        {/* Remove Button */}
        <Button
          variant="outlined"
          color="error"
          onClick={() => console.log("Remove Item")}
        >
          REMOVE
        </Button>
      </div>
    </div>
  );
};

export default CartItem;
