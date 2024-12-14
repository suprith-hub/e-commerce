import React from "react";
import AddressCard from "../AddressCard/AddressCard";
import { Button, Step, StepLabel, Stepper, Box } from "@mui/material";
import OrderTrackingCard from "./OrderTrackingCard";

const steps = [
  "Placed",
  "Confirmed",
  "Shipped",
  "Out for Delivery",
  "Delivered",
];

const OrderDetails = () => {
  return (
    <div className="mx-20 p-4 flex flex-col gap-10">
      {/* Address Section */}
      <AddressCard />

      {/* Stepper Section */}
      <Box className="flex flex-col gap-4">
        <Box
          sx={{
            width: "100%",
            display: "flex",
            alignItems: "center",
            justifyContent: "space-between",
          }}
        >
          <Stepper
            activeStep={1}
            alternativeLabel
            sx={{
              width: "100%",
              padding: 0,
            }}
          >
            {steps.map((label) => (
              <Step key={label}>
                <StepLabel
                  sx={{
                    "& .MuiStepLabel-label": {
                      fontSize: "14px",
                      fontWeight: "500",
                      color: "#4A5578",
                    },
                    "& .Mui-completed .MuiStepLabel-label": {
                      color: "#007BFF",
                    },
                    "& .Mui-active .MuiStepLabel-label": {
                      color: "#000",
                    },
                  }}
                >
                  {label}
                </StepLabel>
              </Step>
            ))}
          </Stepper>
          <Button
            sx={{
              marginLeft: "16px",
              backgroundColor: "#D92D20",
              color: "#fff",
              fontWeight: 500,
              textTransform: "none",
              padding: "8px 16px",
              borderRadius: "8px",
              "&:hover": {
                backgroundColor: "#B22A1A",
              },
            }}
          >
            Cancel Order
          </Button>
        </Box>
      </Box>

      {/* Order Tracking Cards Section */}
      <div className="flex flex-col gap-4">
        {[1, 1, 1, 1].map((item, index) => (
          <OrderTrackingCard key={index} />
        ))}
      </div>
    </div>
  );
};

export default OrderDetails;
