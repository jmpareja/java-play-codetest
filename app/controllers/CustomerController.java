package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ArrayNode;
import play.libs.Json;

import play.*;
import play.mvc.*;

import java.util.*;

public class CustomerController extends Controller {

	public Result sortData() {
		JsonNode json = request().body().asJson();
		if (json == null) {
			return badRequest("Expecting Json data");
		} else {
			if (json.isArray()) {
				List<CustomerInfo> customers = new ArrayList<CustomerInfo>();
				Iterator<JsonNode> it = json.elements();
				while (it.hasNext()) {
					JsonNode node  = it.next();
					try {
						CustomerInfo info = Json.fromJson(node, CustomerInfo.class);
						customers.add(info);
					} catch (Exception e) {
						return badRequest("exception: " + e);
					}
				}

				Collections.sort(customers, CustomerInfo.DUETIME_ORDER);
				return ok(Json.toJson(customers));
			} else {
				return badRequest("Expecting Array of Json data");
			}

		}
	}
}
