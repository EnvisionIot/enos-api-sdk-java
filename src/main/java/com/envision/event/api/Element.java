package com.envision.event.api;

import java.io.IOException;
import java.io.Serializable;

public interface Element extends Serializable {

	public void accept(EventVisitor visitor) throws IOException;
}
