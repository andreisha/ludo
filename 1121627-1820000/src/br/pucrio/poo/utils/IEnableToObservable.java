package br.pucrio.poo.utils;

public interface IEnableToObservable {
	public void registerEnableToObserver(IEnableToObserver observer);
    public void removeEnableToObserver(IEnableToObserver observer);
    public void notifyEnableToObservers();
}
