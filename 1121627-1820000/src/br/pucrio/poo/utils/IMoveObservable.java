package br.pucrio.poo.utils;

public interface IMoveObservable{
	public void registerMoveObserver(IObserver observer);
    public void removeMoveObserver(IObserver observer);
    public void notifyMoveObservers();
}