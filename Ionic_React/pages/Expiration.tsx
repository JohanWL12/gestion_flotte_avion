import { IonButton, IonButtons, IonCard, IonContent, IonHeader, IonItem, IonList, IonMenuButton, IonPage, IonSelect, IonSelectOption, IonTitle, IonToolbar } from "@ionic/react";
import { useState } from "react";
import { useHistory } from "react-router";
import ListAssurance from "../components/ListAssurance";

const Expiration: React.FC = () =>
{
    // var exp:any=<p>No result</p>;
    const [nbmois, setNbMois] = useState(null);
    const history = useHistory();
    // function redirect()
    // {
    //     window.location.href = `/assurances/expiration/${nbmois}`;
    //     return null;
    // }
    return (
        <IonPage>
            <IonHeader>
                <IonToolbar>
                    <IonTitle>Assurance à expiration</IonTitle>
                    <IonButtons slot="start">
                        <IonMenuButton />
                    </IonButtons>
                </IonToolbar>
            </IonHeader>
            <IonContent>
                <IonCard>
                    <IonList>
                        <IonItem>
                            <IonSelect interface="popover" placeholder="Choisir le nombre de mois"
                                onIonChange={(ev) => setNbMois(ev.detail.value)}>
                                <IonSelectOption value="1">1</IonSelectOption>
                                <IonSelectOption value="3">3</IonSelectOption>
                            </IonSelect>
                        </IonItem>
                    </IonList>
                </IonCard>
                <IonCard>

                    <IonButton onClick={(event) =>
                    {
                        event.preventDefault();
                        history.push(`/assurances/expiration/${nbmois}`)
                    }}>Valider</IonButton>
                </IonCard>
            </IonContent>
        </IonPage>
    );
}

export default Expiration;