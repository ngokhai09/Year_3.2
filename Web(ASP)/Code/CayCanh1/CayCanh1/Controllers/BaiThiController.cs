using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using CayCanh1.Models;

namespace CayCanh1.Controllers
{
    public class BaiThiController : Controller
    {
        // GET: BaiThi
        QLBanChauCanhEntities1 db = new QLBanChauCanhEntities1();

        public ActionResult Index()
        {
            return View();
        }
        public ActionResult create()
        {
            return View();
        }
        

    }
}