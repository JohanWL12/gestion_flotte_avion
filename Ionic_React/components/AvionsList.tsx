import { IonButton, IonCard, IonCardContent, useIonToast } from '@ionic/react';
import { useHistory } from 'react-router';
import { checkConnection } from '../models/sendRequest';

export interface AvionsList
{
  donnees: Array<any>;
}

const AvionsListItem: React.FC<AvionsList> = ({ donnees }) =>
{
  //const {data, error} = GetData("/avion","get",null);
  const history = useHistory();
  const [toast] = useIonToast();

  const callback_success = (/* history: any, */ idAvion: any) =>
  {
    console.log("MIPUSH EH");
    
    history.push(`/details/${idAvion}`);
  }

  const callback_error = () =>
  {
    toast({
      message: "Veuillez vous connecter pour accéder à cette page",
      duration: 3000,
      position: 'bottom'
    });
    history.push('/avions');
  }

  return (
    <div>
      <IonCard>
        <table width="100%" border={1}>
          <th>#</th>
          <th>Matricule</th>
          <th>Marque</th>
          <th>Modele</th>
          {donnees.map((d) =>
            <tr>
              <td text-align="center">{d.idAvion}</td>
              <td text-align="center">{d.matricule}</td>
              <td text-align="center">{d.modele.marque.marque}</td>
              <td text-align="center">{d.modele.modele}</td>
              <td text-align="center">
                <IonButton onClick={(event) =>
                {
                  checkConnection(callback_success, callback_error,(d.idAvion));

                }}>Voir plus</IonButton></td>
            </tr>
          )}
        </table>
        <IonCardContent>
          <div className="center">

          </div>
          <hr />
          <div className="center">

          </div>
        </IonCardContent>
      </IonCard>
    </div>
  );
};

export default AvionsListItem;