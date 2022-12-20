import { IonCard, IonCardHeader, IonCardSubtitle, IonCardTitle, IonContent } from "@ionic/react";

export interface Assurance
{
    avion: any;
    datepayement?: string,
    dateexpiration?: string;
}

const Assurance: React.FC<Assurance> = ({ avion, datepayement, dateexpiration }) =>
{
    return (
        <IonCard>
            <IonCardHeader>
                <IonCardTitle>{avion.matricule}</IonCardTitle>
                <IonCardSubtitle> {avion.modele.marque.marque + " " + avion.modele.modele}</IonCardSubtitle>

                <IonCardSubtitle>Date de payement: {datepayement}</IonCardSubtitle>
                <IonCardSubtitle>Date d'expiration: {dateexpiration}</IonCardSubtitle>
            </IonCardHeader>
        </IonCard>
    );
}

export default Assurance;