package agh.to.lab.totalizator;

import java.net.URI;

public class AndroidSender implements ISender {

	@Override
	public void send(URI uri, String value) {
		System.out.println(uri.getPath() + ": " + value);
	}

}
