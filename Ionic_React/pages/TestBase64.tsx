import { IonContent, IonHeader, IonItem, IonPage, IonTitle, IonToolbar } from "@ionic/react";
import { addImage } from "../models/convertBase64";

const TestBase64: React.FC = () => {
    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>Image to Base64</IonTitle>
                </IonToolbar>
            </IonHeader>
            <IonContent>
                <form className="ion-padding">
                    <IonItem>
                        <input type="file" accept="image/*" name="image" onChange={(e: any) => addImage(e)} />
                    </IonItem>
                </form>
            </IonContent>
        </IonPage>
    );
}

export default TestBase64;