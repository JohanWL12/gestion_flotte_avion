import { IonButton, IonContent, IonHeader, IonItem, IonPage, IonTitle, IonToolbar } from "@ionic/react";
import { useState } from "react";
import { useHistory, useParams } from "react-router";
import { saveOrUpdateImage } from "../models/convertBase64";

const ChangeImage: React.FC = () => {
    const [image, setImage] = useState(null);
    let history = useHistory();
    const { idavion } = useParams<{ idavion: string; }>();

    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>Changer la photo</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent>
                <form className="ion-padding">
                    <IonItem>
                        <input type="file" accept="image/*" name="image" onChange={(e: any) => setImage(e)} />
                    </IonItem>
                    <IonButton className="ion-margin-top" expand="block" onClick={(e) => {
                        saveOrUpdateImage(image, idavion, history)
                    }}>Valider</IonButton>
                </form>
            </IonContent>
        </IonPage>
    );
}

export default ChangeImage;