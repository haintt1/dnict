package vn.dnict.lichcoquan.utils;

import java.util.List;

import com.liferay.portal.kernel.util.Validator;

import lichcoquan.service.model.Lichcoquan;

public class LichcoquanValidator {
	public static boolean validateLichCoquan(Lichcoquan obj, List<String> errors) throws Exception {
		boolean valid = true;
		if (Validator.isNull(obj.getContent())) {
			errors.add("alias-required");
			valid = false;
		}
		return valid;
	}
}
