/**
 * 格式化时间
 */
export function dateFormat(date,fmt = "YYYY-MM-DD HH:mm:ss") {
  let moment = require("moment");
  return moment(date).format(fmt);

}
