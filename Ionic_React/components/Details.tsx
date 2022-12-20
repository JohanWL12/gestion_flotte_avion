import {  IonCard, IonCardHeader, IonCardTitle,  IonContent,  IonHeader, IonGrid, IonTitle, IonToolbar, IonRow, IonCol } from "@ionic/react";
import ExploreContainer from "./ExploreContainer";

export interface Detailsavion{
  image: any;
  avion:any;
  modele:any;
  kilometrages:Array<any>;
}

const Details: React.FC<Detailsavion>=({image,avion,modele,kilometrages})=>{
    //console.log(image.base);
    return (

      <IonContent fullscreen>
        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">Détails d'un avion</IonTitle>
          </IonToolbar>
        </IonHeader>

        <IonGrid>
          <IonRow>
            <IonCol>
              <IonCard>
               <img width="250" src={'data:image/png;base64,'+image.base} alt="" />
              </IonCard>
            </IonCol>

            <IonCol>
            <IonCard>
              <IonCardHeader>
                <IonCardTitle>Véhicule: { avion.matricule }</IonCardTitle>
              </IonCardHeader>
              <IonCardHeader>
                <IonCardTitle>Modèle: { modele.marque.marque+" "+modele.modele }</IonCardTitle>
              </IonCardHeader>
          </IonCard>
            </IonCol>
          </IonRow>
        </IonGrid>

        

        

        <IonCard>
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
      </IonContent>
    );
};

export default Details;