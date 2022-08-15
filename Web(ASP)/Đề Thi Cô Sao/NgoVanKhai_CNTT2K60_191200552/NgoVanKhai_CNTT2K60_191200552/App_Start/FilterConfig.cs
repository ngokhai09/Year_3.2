using System.Web;
using System.Web.Mvc;

namespace NgoVanKhai_CNTT2K60_191200552
{
    public class FilterConfig
    {
        public static void RegisterGlobalFilters(GlobalFilterCollection filters)
        {
            filters.Add(new HandleErrorAttribute());
        }
    }
}
