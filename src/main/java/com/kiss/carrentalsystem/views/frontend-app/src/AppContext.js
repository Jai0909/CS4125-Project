import React, { createContext, useContext, useState } from "react";

const AppContext = createContext();

export const useAppContext = () => {
    return useContext(AppContext);
};

export const AppProvider = ({ children }) => {
    const [searchResultsMakeModel, setSearchResultsMakeModel] = useState([]);
    const [searchResultsType, setSearchResultsType] = useState([]);
    const [searchResultsMileage, setSearchResultsMileage] = useState([]);

    return (
        <AppContext.Provider
            value={{
                searchResultsMakeModel,
                setSearchResultsMakeModel,
                searchResultsType,
                setSearchResultsType,
                searchResultsMileage,
                setSearchResultsMileage,
            }}
        >
            {children}
        </AppContext.Provider>
    );
};
