package com.github.vacxe.googleplaycli

import com.github.vacxe.googleplaycli.actions.apks.configuration.ApksListConfiguration
import com.github.vacxe.googleplaycli.actions.apks.configuration.ApksUploadConfiguration
import com.github.vacxe.googleplaycli.actions.apks.mapper.ApksListMapper
import com.github.vacxe.googleplaycli.actions.apks.mapper.ApksUploadMapper
import com.github.vacxe.googleplaycli.actions.bundles.configuration.BundlesListConfiguration
import com.github.vacxe.googleplaycli.actions.bundles.configuration.BundlesUploadConfiguration
import com.github.vacxe.googleplaycli.actions.bundles.mapper.BundlesListMapper
import com.github.vacxe.googleplaycli.actions.bundles.mapper.BundlesUploadMapper
import com.github.vacxe.googleplaycli.actions.deobfuscationfiles.configuration.DeobfuscationfilesUploadConfiguration
import com.github.vacxe.googleplaycli.actions.deobfuscationfiles.mapper.DeobfuscationfilesUploadMapper
import com.github.vacxe.googleplaycli.actions.details.configuration.DetailsGetConfiguration
import com.github.vacxe.googleplaycli.actions.details.configuration.DetailsPatchConfiguration
import com.github.vacxe.googleplaycli.actions.details.configuration.DetailsUpdateConfiguration
import com.github.vacxe.googleplaycli.actions.details.mapper.DetailsGetMapper
import com.github.vacxe.googleplaycli.actions.details.mapper.DetailsPatchMapper
import com.github.vacxe.googleplaycli.actions.details.mapper.DetailsUpdateMapper
import com.github.vacxe.googleplaycli.actions.internalappsharingartifacts.configuration.InternalappsharingartifactsUploadapkConfiguration
import com.github.vacxe.googleplaycli.actions.internalappsharingartifacts.configuration.InternalappsharingartifactsUploadbundleConfiguration
import com.github.vacxe.googleplaycli.actions.internalappsharingartifacts.mapper.InternalappsharingartifactsUploadapkMapper
import com.github.vacxe.googleplaycli.actions.internalappsharingartifacts.mapper.InternalappsharingartifactsUploadbundleMapper
import com.github.vacxe.googleplaycli.actions.orders.configuration.OrdersRefundConfiguration
import com.github.vacxe.googleplaycli.actions.orders.mapper.OrderRefundMapper
import com.github.vacxe.googleplaycli.actions.reviews.configuration.ReviewsGetConfiguration
import com.github.vacxe.googleplaycli.actions.reviews.configuration.ReviewsListConfiguration
import com.github.vacxe.googleplaycli.actions.reviews.configuration.ReviewsReplyConfiguration
import com.github.vacxe.googleplaycli.actions.reviews.mapper.ReviewsGetMapper
import com.github.vacxe.googleplaycli.actions.reviews.mapper.ReviewsListMapper
import com.github.vacxe.googleplaycli.actions.reviews.mapper.ReviewsReplyMapper
import com.github.vacxe.googleplaycli.actions.tracks.configuration.TracksGetConfiguration
import com.github.vacxe.googleplaycli.actions.tracks.configuration.TracksListConfiguration
import com.github.vacxe.googleplaycli.actions.tracks.configuration.TracksPatchConfiguration
import com.github.vacxe.googleplaycli.actions.tracks.configuration.TracksUpdateConfiguration
import com.github.vacxe.googleplaycli.actions.tracks.mapper.TracksGetMapper
import com.github.vacxe.googleplaycli.actions.tracks.mapper.TracksListMapper
import com.github.vacxe.googleplaycli.actions.tracks.mapper.TracksPatchMapper
import com.github.vacxe.googleplaycli.actions.tracks.mapper.TracksUpdateMapper
import com.google.api.services.androidpublisher.model.*
import com.xenomachina.argparser.ArgParser

object Commands {

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/apks">Apks</a>
     */
    object Apks {
        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/apks/list">list</a>
         */
        fun list(args: Array<String>): ApksListResponse {
            ArgParser(args).parseInto(::ApksListConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return ApksListMapper().map(this).let { manager.apksList(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/apks/upload">upload</a>
         */
        fun upload(args: Array<String>): Apk {
            ArgParser(args).parseInto(::ApksUploadConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return ApksUploadMapper().map(this).let { manager.apksUpload(it) }
            }
        }
    }

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/apks/upload">Bundles</a>
     */
    object Bundles {
        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/bundles/list">list</a>
         */
        fun list(args: Array<String>): BundlesListResponse {
            ArgParser(args).parseInto(::BundlesListConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return BundlesListMapper().map(this).let { manager.bundlesList(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/bundles/upload">upload</a>
         */
        fun upload(args: Array<String>): Bundle {
            ArgParser(args).parseInto(::BundlesUploadConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return BundlesUploadMapper().map(this).let { manager.bundlesUpload(it) }
            }
        }
    }

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/deobfuscationfiles">Deobfuscationfiles</a>
     */
    object Deobfuscationfiles {

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/deobfuscationfiles/upload">upload</a>
         */
        fun upload(args: Array<String>): DeobfuscationFilesUploadResponse {
            ArgParser(args).parseInto(::DeobfuscationfilesUploadConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return DeobfuscationfilesUploadMapper().map(this).let { manager.deobfuscationFilesUpload(it) }
            }
        }
    }

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/details">Details</a>
     */
    object Details {

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/details/get">get</a>
         */
        fun get(args: Array<String>): AppDetails {
            ArgParser(args).parseInto(::DetailsGetConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return DetailsGetMapper().map(this).let { manager.detailsGet(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/details/patch">patch</a>
         */
        fun patch(args: Array<String>): AppDetails {
            ArgParser(args).parseInto(::DetailsPatchConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return DetailsPatchMapper().map(this).let { manager.detailsPatch(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/details/update">update</a>
         */
        fun update(args: Array<String>): AppDetails {
            ArgParser(args).parseInto(::DetailsUpdateConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return DetailsUpdateMapper().map(this).let { manager.detailsUpdate(it) }
            }
        }
    }

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/tracks">Tracks</a>
     */
    object Tracks {

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/tracks/get">get</a>
         */
        fun get(args: Array<String>): Track {
            ArgParser(args).parseInto(::TracksGetConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return TracksGetMapper().map(this).let { manager.tracksGet(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/tracks/list">list</a>
         */
        fun list(args: Array<String>): TracksListResponse {
            ArgParser(args).parseInto(::TracksListConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return TracksListMapper().map(this).let { manager.tracksList(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/tracks/patch">patch</a>
         */
        fun patch(args: Array<String>): Track {
            ArgParser(args).parseInto(::TracksPatchConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return TracksPatchMapper().map(this).let { manager.tracksPatch(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/edits/tracks/update">update</a>
         */
        fun update(args: Array<String>): Track {
            ArgParser(args).parseInto(::TracksUpdateConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return TracksUpdateMapper().map(this).let { manager.tracksUpdate(it) }
            }
        }
    }

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/internalappsharingartifacts">Internalappsharingartifacts</a>
     */
    object Internalappsharingartifacts {
        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/internalappsharingartifacts/uploadapk">uploadapk</a>
         */
        fun uploadApk(args: Array<String>): InternalAppSharingArtifact {
            ArgParser(args).parseInto(::InternalappsharingartifactsUploadapkConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return InternalappsharingartifactsUploadapkMapper().map(this).let { manager.internalappsharingartifactsUploadapk(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/internalappsharingartifacts/uploadbundle">uploadbundle</a>
         */
        fun uploadBundle(args: Array<String>): InternalAppSharingArtifact {
            ArgParser(args).parseInto(::InternalappsharingartifactsUploadbundleConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return InternalappsharingartifactsUploadbundleMapper().map(this).let { manager.internalappsharingartifactsUploadbundle(it) }
            }
        }
    }

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/orders">Orders</a>
     */
    object Orders {
        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/orders/refund">refund</a>
         */
        fun refund(args: Array<String>): Void {
            ArgParser(args).parseInto(::OrdersRefundConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return OrderRefundMapper().map(this).let { manager.ordersRefund(it) }
            }
        }
    }

    /**
     * @see <a href="https://developers.google.com/android-publisher/api-ref/reviews">Reviews</a>
     */
    object Reviews {
        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/reviews/list">list</a>
         */
        fun list(args: Array<String>): ReviewsListResponse {
            ArgParser(args).parseInto(::ReviewsListConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return ReviewsListMapper().map(this).let { manager.reviewsList(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/reviews/get">get</a>
         */
        fun get(args: Array<String>): Review {
            ArgParser(args).parseInto(::ReviewsGetConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return ReviewsGetMapper().map(this).let { manager.reviewsGet(it) }
            }
        }

        /**
         * @see <a href="https://developers.google.com/android-publisher/api-ref/reviews/reply">reply</a>
         */
        fun reply(args: Array<String>): ReviewsReplyResponse {
            ArgParser(args).parseInto(::ReviewsReplyConfiguration).run {
                val manager = PlayStoreCli(serviceAccountJson, packageName)
                return ReviewsReplyMapper().map(this).let { manager.reviewsReply(it) }
            }
        }
    }
}
