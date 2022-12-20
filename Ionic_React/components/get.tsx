import React, { useEffect, useState } from "react";
import axios from "axios";

function getItems(url: string)
{
    const [item, setItem] = useState<any>([]);
    const [error, setError] = useState<any>(null);

    useEffect(function ()
    {
        axios.get(url)
            .then(function (response)
            {
                console.log("success");
                console.log(response);
                setItem(response);
            })
            .catch(function (err)
            {
                console.log("error");
                console.log(error);
                setError(err);
            })
    }, [url]);

    return { item, error };
}

export default getItems;