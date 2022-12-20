import {  IonCard, IonCardHeader, IonCardTitle,  IonContent,  IonHeader, IonMenuButton, IonPage, IonRow, IonTitle, IonToolbar } from "@ionic/react";
import ExploreContainer from "./ExploreContainer";

export interface Detailsavion{
  photo:any;
  avion:any;
  modele:any;
  kilometrages:Array<any>;
}

const Details: React.FC<Detailsavion>=({photo,avion,modele,kilometrages})=>{
    

    return (

      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Détails d'un avion</IonTitle>
          </IonToolbar>
        </IonHeader>
        <IonCard>
          <IonCardHeader>
            <IonCardTitle>Véhicule: { avion.matricule }</IonCardTitle>
          </IonCardHeader>
          <IonCardHeader>
            <IonCardTitle>Modèle: { modele.marque.marque+" "+modele.modele }</IonCardTitle>
          </IonCardHeader>
        </IonCard>
        <IonCard>
          <img alt="" src={photo} />
          <table width="100%" border={1}>
            <thead>
            <tr>
              <th>Kilometrage début</th>
              <th>Kilometrage fin</th>
              <th>Date</th>
            </tr>
            </thead>
            <tbody>
            {kilometrages.map((k)=>(
              <tr>
                <td>{ k.debutKm }</td>
                <td>{ k.finKm }</td>
                <td>{ k.date }</td>
              </tr>
              ))}
            </tbody>
          </table>
        </IonCard>
        <ExploreContainer name="details" />
      </IonContent>
    );
};

export default Details;