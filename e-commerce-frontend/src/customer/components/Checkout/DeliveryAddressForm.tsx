import { Box, Button, Grid2, TextField } from "@mui/material";
import React from "react";
import AddressCard from "../AddressCard/AddressCard";

const DeliveryAddressForm = () => {
  function handleSubmit(e: any) {
    e.preventDefault();
    const data = new FormData(e.currentTarget);
    console.log({
      email: data.get("email"),
      password: data.get("password"),
    });
  }

  return (
    <div>
      <Grid2 container spacing={4}>
        <Grid2 className="border rounded-e-md shadow-md h-[30.5rem] overflow-y-scroll">
          <div className="p-5 py-7 border-b cursor-pointer">
            <AddressCard />
            <Button>Deliver Here</Button>
          </div>
        </Grid2>
        <Grid2 size={{ xs: 12, lg: 7 }}>
          <Box className="border rounded-e-md shadow-md-5 p-5">
            <form action="" onSubmit={handleSubmit}>
              <Grid2 container spacing={3}>
                <Grid2 size={{ xs: 12, sm: 6 }}>
                  <TextField
                    id="firstName"
                    name="firstName"
                    label="First Name"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid2>
                <Grid2 size={{ xs: 12, sm: 6 }}>
                  <TextField
                    id="lastName"
                    name="lastName"
                    label="Last Name"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid2>
                <Grid2 size={{ xs: 12 }}>
                  <TextField
                    id="address"
                    name="address"
                    label="Address"
                    fullWidth
                    autoComplete="given-name"
                    multiline
                    rows={4}
                  />
                </Grid2>

                <Grid2 size={{ xs: 12, sm: 6 }}>
                  <TextField
                    id="city"
                    name="city"
                    label="City"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid2>
                <Grid2 size={{ xs: 12, sm: 6 }}>
                  <TextField
                    id="state"
                    name="state"
                    label="State/Provience/Region"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid2>

                <Grid2 size={{ xs: 12, sm: 6 }}>
                  <TextField
                    id="zip"
                    name="zip"
                    label="Zip"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid2>
                <Grid2 size={{ xs: 12, sm: 6 }}>
                  <TextField
                    id="phone"
                    name="phone"
                    label="Phone Number"
                    fullWidth
                    autoComplete="given-name"
                  />
                </Grid2>
                <Button type="submit">Deliver Here</Button>
              </Grid2>
            </form>
          </Box>
        </Grid2>
      </Grid2>
    </div>
  );
};

export default DeliveryAddressForm;
