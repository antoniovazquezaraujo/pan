package views;

import org.openswing.swing.mdi.client.InternalFrame;


public class ScreenFrame extends InternalFrame {
/**
	 * 
	 */
	private static final long serialVersionUID = 4566464646464878861L;
	//	BorderLayout borderLayout1 = new BorderLayout();
	Screen screen = null;

	public ScreenFrame(Screen screen) {
		this.screen = screen;
//		setSize(750, 500);
		setTitle(screen.getTitle());
		jbInit();
	}

	private void jbInit() {
//		this.getContentPane().setLayout(borderLayout1);
		add(screen.getPanel());//, BorderLayout.CENTER);
//		this.getContentPane().setMinimumSize((new Dimension(200,200)));
//		this.setSize(getContentPane().getPreferredSize());
		revalidate();
		pack();
	}
}
