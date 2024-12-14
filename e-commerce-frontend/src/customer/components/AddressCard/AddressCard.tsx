import React from "react";

const AddressCard = () => {
  return (
    <div className="border border-gray-600">
      <div className="text-xl pb-4 font-semibold">Suprith K G</div>
      <div className="text-md">123, Main Street, New York, NY 12345</div>
      <div className="text-md">
        {" "}
        Phone Number <br /> +91 1234567890
      </div>
    </div>
  );
};

export default AddressCard;
