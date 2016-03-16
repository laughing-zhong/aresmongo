function obj_to_url(obj) {
  return "/view/" + obj.service + "/" + obj.method + "?" + jQuery.param(obj.params)
}