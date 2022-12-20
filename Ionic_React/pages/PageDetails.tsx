import { IonButtons, IonHeader, IonMenuButton, IonPage, IonTitle, IonToolbar } from "@ionic/react";
import { useParams } from "react-router";
import Details from "../components/Details";
import ExploreContainer from '../components/ExploreContainer';
import { useItems } from "../models/sendRequest";

const PageDetails: React.FC = () =>
{
  const { idavion } = useParams<{ idavion: string; }>();

  var { item, error } = useItems("/avions/" + idavion.toString() + "/details");
  if (item.length == 0)
  {
    return <h1>Waiting...</h1>
  } else
  {
    return (

      <IonPage>
        <IonHeader>
          <IonToolbar>
            <IonButtons slot="start">
              <IonMenuButton />
            </IonButtons>
            <IonTitle>Détails véhicule</IonTitle>
          </IonToolbar>
        </IonHeader>
        <Details image={item.image} avion={item.avion} modele={item.modele} kilometrages={item.kilometrages}></Details>
      </IonPage>

    );
  }
}

export default PageDetails;