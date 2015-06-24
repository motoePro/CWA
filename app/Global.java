import play.GlobalSettings;
import play.api.mvc.EssentialFilter;
import play.filters.csrf.CSRFFilter;
import play.*;

public class Global extends GlobalSettings {

	/**
	 * フィルター定義
	 *
	 * @param <T>
	 * @return
	 */
	@Override
	public <T extends EssentialFilter> Class<T>[] filters() {
		return new Class[]{
				CSRFFilter.class
		};
	}

}
