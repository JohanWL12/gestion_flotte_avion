import axios from "axios";
import { useHistory } from "react-router";
import { getURL } from "./sendRequest";

const getBase64 = (file: File) => {
    return new Promise(resolve => {
        let reader = new FileReader();
        reader.readAsDataURL(file);
        reader.onload = () => {
            let base64 = reader.result as string;
            resolve(base64);
        };
    });
};

export const saveOrUpdateImage = (e: any, idavion: string, history: any) => {
    let file = e.target.files[0];
    getBase64(file)
        .then(result => {
            let imageSrc = String(result);
            axios.get(getURL("/" + idavion + "/image/" + imageSrc))
                .then(() => {
                    history.push("/details/" + idavion);
                })
                .catch(err => {
                    console.log(err);
                });

        })
        .catch(error => {
            console.log(error);
        });
};
