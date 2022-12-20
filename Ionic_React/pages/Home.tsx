import AvionsListItem from '../components/AvionsList';
import GetData from '../data/GetData';

import {
  IonContent,
  IonHeader,
  IonPage,
  IonRefresher,
  IonRefresherContent,
  IonTitle,
  IonToolbar

} from '@ionic/react';
import './Home.css';

const Home: React.FC = () => {
  const {data, error} = GetData("/avions","get",null);

  const refresh = (e: CustomEvent) => {
    setTimeout(() => {
      e.detail.complete();
    }, 3000);
  };

  return (
    <IonPage id="home-page">
     <IonHeader>
        <IonToolbar>
          <IonTitle>Liste des avions</IonTitle>
        </IonToolbar>
      </IonHeader>
      <IonContent fullscreen>
        <IonRefresher slot="fixed" onIonRefresh={refresh}>
          <IonRefresherContent></IonRefresherContent>
        </IonRefresher>

        <IonHeader collapse="condense">
          <IonToolbar>
            <IonTitle size="large">
            Liste des avions
            </IonTitle>
          </IonToolbar>
        </IonHeader>

        <AvionsListItem donnees={data}/>
        
      </IonContent>
    </IonPage>
  );
};

export default Home;