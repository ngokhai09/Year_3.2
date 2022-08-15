using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Net;
using System.Web;
using System.Web.Mvc;
using NgoVanKhai_CNTT2K60_191200552.Models;

namespace NgoVanKhai_CNTT2K60_191200552.Controllers
{
    public class BaiThiController : Controller
    {
        QLBanNoiEntities db = new QLBanNoiEntities();

        // GET: BaiThi
        public ActionResult Index()
        {
            return View();
        }
        public ActionResult RenCat()
        {
            List<PhanLoai> phanLoais = db.PhanLoais.ToList();
            return PartialView("Header", phanLoais);
        }
        public ActionResult RenProduct()
        {
            List<SanPham> sanPhams = db.SanPhams.ToList();
            return PartialView("MainContent", sanPhams);
        }
        public ActionResult RenProductByCatId(string id)
        {
            List<SanPham> sanPhams;
            if (id == "-1")
            {
                sanPhams = db.SanPhams.ToList();
            }
            else
            {
                sanPhams = db.SanPhams.Where(n => n.MaPhanLoai == id).ToList();
            }
            return PartialView("MainContent", sanPhams);
        }
        public ActionResult Edit(string id)
        {
            if (id == null)
            {
                return new HttpStatusCodeResult(HttpStatusCode.BadRequest);
            }
            SanPham sanPham = db.SanPhams.Find(id);
            if (sanPham == null)
            {
                return HttpNotFound();
            }
            ViewBag.MaPhanLoai = new SelectList(db.PhanLoais, "MaPhanLoai", "PhanLoaiChinh", sanPham.MaPhanLoai);
            ViewBag.MaPhanLoaiPhu = new SelectList(db.PhanLoaiPhus, "MaPhanLoaiPhu", "TenPhanLoaiPhu", sanPham.MaPhanLoaiPhu);
            return View(sanPham);
        }


        [HttpPost]
        [ValidateAntiForgeryToken]
        public ActionResult Edit([Bind(Include = "MaSanPham,TenSanPham,MaPhanLoai,GiaNhap,DonGiaBanNhoNhat,DonGiaBanLonNhat,TrangThai,MoTaNgan,AnhDaiDien,NoiBat,MaPhanLoaiPhu")] SanPham sanPham)
        {
            if (ModelState.IsValid)
            {
                db.Entry(sanPham).State = EntityState.Modified;
                db.SaveChanges();
                return RedirectToAction("Index");
            }
            ViewBag.MaPhanLoai = new SelectList(db.PhanLoais, "MaPhanLoai", "PhanLoaiChinh", sanPham.MaPhanLoai);
            ViewBag.MaPhanLoaiPhu = new SelectList(db.PhanLoaiPhus, "MaPhanLoaiPhu", "TenPhanLoaiPhu", sanPham.MaPhanLoaiPhu);
            return View(sanPham);
        }
    }
}