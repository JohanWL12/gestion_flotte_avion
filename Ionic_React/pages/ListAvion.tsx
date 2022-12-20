import AvionsListItem from '../components/AvionsList';
// import GetData from '../data/GetData';

import
  {
    IonButtons,
    IonContent,
    IonHeader,
    IonMenuButton,
    IonPage,
    IonRefresher,
    IonRefresherContent,
    IonTitle,
    IonToolbar

  } from '@ionic/react';
// import './Home.css';
import { useItems } from '../models/sendRequest';
import { useHistory } from 'react-router';

const ListAvions: React.FC = () =>
{
  //   const {data, error} = GetData("/avion","get",null);
  const { item, error } = useItems("/avions");
  const refresh = (e: CustomEvent) =>
  {
    setTimeout(() =>
    {
      e.detail.complete();
    }, 3000);
  };


  return (
    <IonPage id="home-page">
      <IonHeader>
        <IonToolbar>
          <IonTitle>Liste des Avions</IonTitle>
          <IonButtons slot="start">
            <IonMenuButton />
          </IonButtons>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonRefresher slot="fixed" onIonRefresh={refresh}>
          <IonRefresherContent></IonRefresherContent>
        </IonRefresher>

        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">
              Liste des Avions
            </IonTitle>
          </IonToolbar>
        </IonHeader>

        <AvionsListItem donnees={item} />

      </IonContent>
    </IonPage>
  );
};

export default ListAvions;