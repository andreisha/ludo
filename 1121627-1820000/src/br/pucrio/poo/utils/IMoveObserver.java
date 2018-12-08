
package br.pucrio.poo.utils;

import java.awt.Color;
import java.util.List;

public interface IMoveObserver extends IObserver{

	void finalizeGame(List<Color> classificacoesCores);

}
