//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace BanGiay1.Models
{
    using System;
    using System.Collections.Generic;
    
    public partial class ChiTietSPBan
    {
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2214:DoNotCallOverridableMethodsInConstructors")]
        public ChiTietSPBan()
        {
            this.ChiTietDHs = new HashSet<ChiTietDH>();
        }
    
        public string MaChiTietSP { get; set; }
        public string MaSPTheoMau { get; set; }
        public string KichCo { get; set; }
        public Nullable<int> SoLuong { get; set; }
        public Nullable<long> DonGiaBan { get; set; }
    
        [System.Diagnostics.CodeAnalysis.SuppressMessage("Microsoft.Usage", "CA2227:CollectionPropertiesShouldBeReadOnly")]
        public virtual ICollection<ChiTietDH> ChiTietDHs { get; set; }
        public virtual SPtheoMau SPtheoMau { get; set; }
    }
}
