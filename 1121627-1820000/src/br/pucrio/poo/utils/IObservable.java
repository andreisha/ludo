
package br.pucrio.poo.utils;

import java.awt.Color;
import java.util.List;

public interface IObservable {
	public void registerObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public void notifyObservers();
    public void notifyEndToMoveObservers(List<Color> classificacoesCores) ;
}
