import React from "react";
import { useLoadScript } from "@react-google-maps/api";
import "@reach/combobox/styles.css";
import SearchLocationCombobox from "./SearchCombobox";

const libraries = ["places"];

export default function SearchLocation({ setLocationData }) {
  const { isLoaded, loadError } = useLoadScript({
    googleMapsApiKey: process.env.REACT_APP_GOOGLE_MAPS_API_KEY,
    libraries,
  });
  if (loadError) return "Error loading maps";
  if (!isLoaded) return "Loading Maps";

  return (
    <div>
      <SearchLocationCombobox setLocationData={setLocationData} />
    </div>
  );
}
