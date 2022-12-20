import {
  IonButton,
  IonContent,
  IonIcon,
  IonItem,
  IonLabel,
  IonList,
  IonListHeader,
  IonMenu,
  IonMenuToggle,
  IonNote,
} from '@ionic/react';

import { useHistory, useLocation } from 'react-router-dom';
import { archiveOutline, archiveSharp, bookmarkOutline, heartOutline, heartSharp, mailOutline, mailSharp, paperPlaneOutline, paperPlaneSharp, airplane, person, warningOutline, warningSharp } from 'ionicons/icons';
import './Menu.css';
import { deconnect } from '../models/sendRequest';

interface AppPage {
  url: string;
  iosIcon: string;
  mdIcon: string;
  title: string;
}

const appPages: AppPage[] = [ 
  {
    title: 'Expiration',
    url: '/assurances/expiration',
    iosIcon: warningOutline,
    mdIcon: warningSharp
  },
  {
    title: 'Listes des avions',
    url: '/avions',
    iosIcon: airplane,
    mdIcon: airplane
  },
  {
    title: 'Login',
    url: '/login',
    iosIcon: person,
    mdIcon: person
  }
  
];

const Menu: React.FC = () => {
  const location = useLocation();
  const history=useHistory();

  const callback_deconnect=()=>{
    history.push('/avions');
  };
  
  return (
    <IonMenu contentId="main" type="overlay">
      <IonContent>
        <IonList id="inbox-list">
          <IonListHeader>Gestion flotte avion</IonListHeader>
          <IonNote></IonNote>
          {appPages.map((appPage, index) => {
            return (
              <IonMenuToggle key={index} autoHide={false}>
                <IonItem className={location.pathname === appPage.url ? 'selected' : ''} routerLink={appPage.url} routerDirection="none" lines="none" detail={false}>
                  <IonIcon slot="start" ios={appPage.iosIcon} md={appPage.mdIcon} />
                  <IonLabel>{appPage.title}</IonLabel>
                </IonItem>
              </IonMenuToggle>
            );
          })}
        </IonList>

        <IonList id="labels-list">
          <IonListHeader></IonListHeader>
          <IonItem>
            <IonIcon></IonIcon>
            <IonButton onClick={(ev)=>{
              console.log("deconnect");
              
              deconnect(callback_deconnect);
            }}>Déconnexion</IonButton>
          </IonItem>
        </IonList>
      </IonContent>
    </IonMenu>
  );
};

export default Menu;
