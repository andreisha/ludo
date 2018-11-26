package br.pucrio.poo.utils;

public interface IResultObservable{
	public void registerResultObserver(IObserver observer);
    public void removeResultObserver(IObserver observer);
    public void notifyResultObservers();
}
