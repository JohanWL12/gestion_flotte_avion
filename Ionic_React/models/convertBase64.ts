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

export const addImage = (e: any) => {
    let file = e.target.files[0];
    getBase64(file)
        .then(result => {
            let imageSrc = String(result);
            console.log(file);
            console.log(imageSrc);
        })
        .catch(error => {
            console.log(error);
        });
};
