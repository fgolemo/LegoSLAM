package org.meicogsci.legobot1;

import org.meicogsci.legobot1.map.Map;
import org.meicogsci.legobot1.map.MapForm;

public final class BotSingleton {

	private static final BotSingleton INSTANCE = new BotSingleton();

	private BotSingleton() {
	}

	public static BotSingleton getInstance() {
		return INSTANCE;
	}

	public History history = new History();
	public String nextAction = "";
	public Map map = new Map();
	public MapForm mapForm;

	public void openMapWindow() {
		if (mapForm == null) {
			System.out.println("no MapForm set");
			return;
		} else {

			try {
				for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
						.getInstalledLookAndFeels()) {
					if ("Nimbus".equals(info.getName())) {
						javax.swing.UIManager.setLookAndFeel(info
								.getClassName());
						break;
					}
				}
			} catch (ClassNotFoundException ex) {
				java.util.logging.Logger.getLogger(MapForm.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			} catch (InstantiationException ex) {
				java.util.logging.Logger.getLogger(MapForm.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			} catch (IllegalAccessException ex) {
				java.util.logging.Logger.getLogger(MapForm.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			} catch (javax.swing.UnsupportedLookAndFeelException ex) {
				java.util.logging.Logger.getLogger(MapForm.class.getName())
						.log(java.util.logging.Level.SEVERE, null, ex);
			}
			// </editor-fold>

			/* Create and display the form */
			java.awt.EventQueue.invokeLater(new Runnable() {
				public void run() {
					MapForm mapForm = new MapForm();
					BotSingleton.getInstance().mapForm = mapForm;
					mapForm.setVisible(true);
				}
			});
		}
	}
}