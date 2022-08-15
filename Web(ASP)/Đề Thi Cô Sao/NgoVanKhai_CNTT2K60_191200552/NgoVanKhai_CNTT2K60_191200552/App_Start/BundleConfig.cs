using System.Web;
using System.Web.Optimization;

namespace NgoVanKhai_CNTT2K60_191200552
{
    public class BundleConfig
    {
        // For more information on bundling, visit https://go.microsoft.com/fwlink/?LinkId=301862
        public static void RegisterBundles(BundleCollection bundles)
        {
            bundles.Add(new ScriptBundle("~/bundles/jquery").Include(
                        "~/Scripts/jquery-{version}.js"));

            bundles.Add(new ScriptBundle("~/bundles/jqueryval").Include(
                        "~/Scripts/jquery.validate*"));

            // Use the development version of Modernizr to develop with and learn from. Then, when you're
            // ready for production, use the build tool at https://modernizr.com to pick only the tests you need.
            bundles.Add(new ScriptBundle("~/bundles/modernizr").Include(
                        "~/Scripts/modernizr-*"));

            bundles.Add(new ScriptBundle("~/bundles/bootstrap").Include(
                      "~/Scripts/bootstrap.js"));

            bundles.Add(new StyleBundle("~/Content/css").Include(
                      "~/Content/bootstrap.css",
                      "~/Content/site.css"));

            bundles.Add(new ScriptBundle("~/bundles/myjs").Include(
                      "~/Scripts/js/jquery.min.js",
                      "~/Scripts/js/popper.min.js",
                      "~/Scripts/js/bootstrap.bundle.min.js",
                      "~/Scripts/js/js/jquery-3.0.0.min.js",
                      "~/Scripts/js/plugin.js",
                      "~/Scripts/js/custom.js"));

            bundles.Add(new StyleBundle("~/Content/mycss").Include(
                      "~/Content/css/bootstrap.min.css",
                      "~/Content/css/style.css",
                      "~/Content/css/responsive.cs",
                      "~/Content/css/jquery.mCustomScrollbar.min.css",
                      "~/Content/css/owl.carousel.min.css",
                      "~/Content/css/owl.theme.default.min.css"));
        }
    }
}
